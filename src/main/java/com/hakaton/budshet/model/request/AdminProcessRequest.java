package com.hakaton.budshet.model.request;

import java.util.Date;
import java.util.List;

public class AdminProcessRequest {

    private int id;

    private String description;

    private String number;

    private Date dateCreate;

    private Date dateEnd;

    private List<Integer> previousProcess;

    private List<Integer> nextProcess;

    private int statusDocument;

    private int founderEnterprise;

    private int executorEnterprise;


}
