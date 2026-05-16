package ScheduleLogRepository;

import ScheduleLog.ScheduleLog;

public abstract class ScheduleLogRepositoryAbstract {
    private int numLogs = 0;

    public ScheduleLogRepositoryAbstract() {
        // Atribuição da estrutura de dados que componhará o repositório de schedule
        // logs
    }

    public abstract void addLog(ScheduleLog log);

    public abstract ScheduleLog searchScheduleLog(int logId);

    public abstract void getAllScheduleLogs();

    protected void incrementNumLogs() {
        this.numLogs += 1;
    }

    public int getNumLogs() {
        return this.numLogs;
    }
}
