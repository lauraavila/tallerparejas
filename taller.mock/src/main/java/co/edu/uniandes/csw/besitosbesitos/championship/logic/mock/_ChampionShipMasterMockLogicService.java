/* ========================================================================
 * Copyright 2014 besitosbesitos
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 besitosbesitos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.besitosbesitos.championship.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.besitosbesitos.championship.logic.dto.ChampionShipDTO;
import co.edu.uniandes.csw.besitosbesitos.championship.logic.api.IChampionShipLogicService;
import co.edu.uniandes.csw.besitosbesitos.championship.master.logic.api._IChampionShipMasterLogicService;
import co.edu.uniandes.csw.besitosbesitos.championship.master.logic.dto.ChampionShipMasterDTO;
import co.edu.uniandes.csw.besitosbesitos.referee.logic.api.IRefereeLogicService;
import co.edu.uniandes.csw.besitosbesitos.prize.logic.api.IPrizeLogicService;
import co.edu.uniandes.csw.besitosbesitos.stadium.logic.api.IStadiumLogicService;
import co.edu.uniandes.csw.besitosbesitos.record.logic.api.IRecordLogicService;
import co.edu.uniandes.csw.besitosbesitos.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.besitosbesitos.prize.logic.dto.PrizeDTO;
import co.edu.uniandes.csw.besitosbesitos.stadium.logic.dto.StadiumDTO;
import co.edu.uniandes.csw.besitosbesitos.record.logic.dto.RecordDTO;
import javax.inject.Inject;


public abstract class _ChampionShipMasterMockLogicService implements _IChampionShipMasterLogicService {

    protected static ArrayList<ChampionShipMasterDTO> championShipMasterDtosList = new ArrayList<ChampionShipMasterDTO>() ;
    @Inject
    protected IRefereeLogicService refereePersistance;
    @Inject
    protected IPrizeLogicService prizePersistance;
    @Inject
    protected IStadiumLogicService stadiumPersistance;
    @Inject
    protected IRecordLogicService recordPersistance;
    @Inject
    protected IChampionShipLogicService championShipPersistance;

    public ChampionShipMasterDTO createMasterChampionShip(ChampionShipMasterDTO championShip) {

        championShipPersistance.createChampionShip(championShip.getChampionShipEntity());
        for (PrizeDTO dto : championShip.getCreateprize()) {
            prizePersistance.createPrize(dto);
        }
        for (RecordDTO dto : championShip.getCreaterecords()) {
            recordPersistance.createRecord(dto);
        }
        for (StadiumDTO dto : championShip.getCreatestadiums()) {
            stadiumPersistance.createStadium(dto);
        }
        for (RefereeDTO dto : championShip.getCreatereferees()) {
            refereePersistance.createReferee(dto);
        }
        for (RefereeDTO dto : championShip.getCreatesecondaryReferees()) {
            refereePersistance.createReferee(dto);
        }
        championShipMasterDtosList.add(championShip);
        return championShip;
    }

    public ChampionShipMasterDTO getMasterChampionShip(Long id) {
        for (ChampionShipMasterDTO championShipMasterDTO : championShipMasterDtosList) {
            if (championShipMasterDTO.getChampionShipEntity().getId() == id) {
                return championShipMasterDTO;
            }
        }

        return null;
    }

    public void deleteMasterChampionShip(Long id) {
        for (ChampionShipMasterDTO championShipMasterDTO : championShipMasterDtosList) {
            if (championShipMasterDTO.getChampionShipEntity().getId() == id) {

                for (PrizeDTO dto : championShipMasterDTO.getCreateprize()) {
                    prizePersistance.deletePrize(dto.getId());
                }
                championShipPersistance.deleteChampionShip(championShipMasterDTO.getId());
                championShipMasterDtosList.remove(championShipMasterDTO);
                for (RecordDTO dto : championShipMasterDTO.getCreaterecords()) {
                    recordPersistance.deleteRecord(dto.getId());
                }
                championShipPersistance.deleteChampionShip(championShipMasterDTO.getId());
                championShipMasterDtosList.remove(championShipMasterDTO);
                for (StadiumDTO dto : championShipMasterDTO.getCreatestadiums()) {
                    stadiumPersistance.deleteStadium(dto.getId());
                }
                championShipPersistance.deleteChampionShip(championShipMasterDTO.getId());
                championShipMasterDtosList.remove(championShipMasterDTO);
                for (RefereeDTO dto : championShipMasterDTO.getCreatereferees()) {
                    refereePersistance.deleteReferee(dto.getId());
                }
                championShipPersistance.deleteChampionShip(championShipMasterDTO.getId());
                championShipMasterDtosList.remove(championShipMasterDTO);
                for (RefereeDTO dto : championShipMasterDTO.getCreatesecondaryReferees()) {
                    refereePersistance.deleteReferee(dto.getId());
                }
                championShipPersistance.deleteChampionShip(championShipMasterDTO.getId());
                championShipMasterDtosList.remove(championShipMasterDTO);
            }
        }

    }

    public void updateMasterChampionShip(ChampionShipMasterDTO championShip) {

        // update Prize
        if (championShip.getUpdateprize() != null) {
            for (PrizeDTO dto : championShip.getUpdateprize()) {
                prizePersistance.updatePrize(dto);
            }
        }
        // persist new Prize
        if (championShip.getCreateprize() != null) {
            for (PrizeDTO dto : championShip.getCreateprize()) {
                PrizeDTO persistedPrizeDTO = prizePersistance.createPrize(dto);
                dto = persistedPrizeDTO;
            }
        }
        // delete Prize
        if (championShip.getDeleteprize() != null) {
            for (PrizeDTO dto : championShip.getDeleteprize()) {

                prizePersistance.deletePrize(dto.getId());
            }
        }
        // update Record
        if (championShip.getUpdaterecords() != null) {
            for (RecordDTO dto : championShip.getUpdaterecords()) {
                recordPersistance.updateRecord(dto);
            }
        }
        // persist new Record
        if (championShip.getCreaterecords() != null) {
            for (RecordDTO dto : championShip.getCreaterecords()) {
                RecordDTO persistedRecordDTO = recordPersistance.createRecord(dto);
                dto = persistedRecordDTO;
            }
        }
        // delete Record
        if (championShip.getDeleterecords() != null) {
            for (RecordDTO dto : championShip.getDeleterecords()) {

                recordPersistance.deleteRecord(dto.getId());
            }
        }
        // update Stadium
        if (championShip.getUpdatestadiums() != null) {
            for (StadiumDTO dto : championShip.getUpdatestadiums()) {
                stadiumPersistance.updateStadium(dto);
            }
        }
        // persist new Stadium
        if (championShip.getCreatestadiums() != null) {
            for (StadiumDTO dto : championShip.getCreatestadiums()) {
                StadiumDTO persistedStadiumDTO = stadiumPersistance.createStadium(dto);
                dto = persistedStadiumDTO;
            }
        }
        // delete Stadium
        if (championShip.getDeletestadiums() != null) {
            for (StadiumDTO dto : championShip.getDeletestadiums()) {

                stadiumPersistance.deleteStadium(dto.getId());
            }
        }
        // update Referee
        if (championShip.getUpdatereferees() != null) {
            for (RefereeDTO dto : championShip.getUpdatereferees()) {
                refereePersistance.updateReferee(dto);
            }
        }
        // persist new Referee
        if (championShip.getCreatereferees() != null) {
            for (RefereeDTO dto : championShip.getCreatereferees()) {
                RefereeDTO persistedRefereeDTO = refereePersistance.createReferee(dto);
                dto = persistedRefereeDTO;
            }
        }
        // delete Referee
        if (championShip.getDeletereferees() != null) {
            for (RefereeDTO dto : championShip.getDeletereferees()) {

                refereePersistance.deleteReferee(dto.getId());
            }
        }
        // update Referee
        if (championShip.getUpdatesecondaryReferees() != null) {
            for (RefereeDTO dto : championShip.getUpdatesecondaryReferees()) {
                refereePersistance.updateReferee(dto);
            }
        }
        // persist new Referee
        if (championShip.getCreatesecondaryReferees() != null) {
            for (RefereeDTO dto : championShip.getCreatesecondaryReferees()) {
                RefereeDTO persistedRefereeDTO = refereePersistance.createReferee(dto);
                dto = persistedRefereeDTO;
            }
        }
        // delete Referee
        if (championShip.getDeletesecondaryReferees() != null) {
            for (RefereeDTO dto : championShip.getDeletesecondaryReferees()) {

                refereePersistance.deleteReferee(dto.getId());
            }
        }
    }
}