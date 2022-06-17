package com.idriss.kafkaspringbootconsumer.broker.event;

import java.io.Serializable;

public class EventOp implements Serializable {
    private String status;
    private int idOp;
    private int idAcc;
    private int amount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdOp() {
        return idOp;
    }

    public void setIdOp(int idOp) {
        this.idOp = idOp;
    }

    public int getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(int idAcc) {
        this.idAcc = idAcc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
