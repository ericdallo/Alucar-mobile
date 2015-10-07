package com.alucar.states;

import java.util.Arrays;
import java.util.List;

public enum StatesBr {

    SP,RJ,DF,ES,BA,MG,PE,RS,SC;

    public static List<StatesBr> getAllStates(){
        return Arrays.asList(values());
    }
}
