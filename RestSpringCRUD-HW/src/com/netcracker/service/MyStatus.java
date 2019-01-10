package com.netcracker.service;

public class MyStatus {
    private String status;

    public MyStatus() {
    }

    public MyStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
