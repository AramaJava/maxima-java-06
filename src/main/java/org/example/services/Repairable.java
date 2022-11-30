package org.example.services;

public interface Repairable {
    void startRepair();
    void finishRepair();
    boolean isRepairing();
}
