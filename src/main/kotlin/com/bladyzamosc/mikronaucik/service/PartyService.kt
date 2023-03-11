package com.bladyzamosc.mikronaucik.service

import com.bladyzamosc.mikronaucik.model.structure.Management
import com.bladyzamosc.mikronaucik.model.structure.Party
import java.util.*

class PartyService {
    fun processLoad(partyId: String): Party {
        return Party(partyId, UUID.randomUUID().toString(), Management(), emptyList());
    }
}