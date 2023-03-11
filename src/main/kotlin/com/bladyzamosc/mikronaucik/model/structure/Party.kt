package com.bladyzamosc.mikronaucik.model.structure

data class Party(var id: String, var name: String, var management: Management, var departments: List<Department>) {
}