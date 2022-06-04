package ru.ironball.shikimori.data.entities.common

import com.google.gson.annotations.SerializedName

class RolesResponse(
    @SerializedName("roles") val roles: List<String>,
    @SerializedName("roles_russian") val rolesRussian: List<String>,
    @SerializedName("character") val character: PersonResponse?,
    @SerializedName("person") val author: PersonResponse?,
)