package com.databank.collector.pojos;

public class Parameter {


    private long id;
    private String name;
    private int type_id;


    public Parameter(int type_id, String name, long id) {
        this.id = id;
        this.name = name;
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
