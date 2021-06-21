package com.sanam.database.preferenceDelegation

import com.sanam.database.dto.MusicModelDto


public class PreferenceDelegation(preference: UserPreference<Array<MusicModelDto>>) :
    UserPreference<Array<MusicModelDto>> by preference {

}