package ScheduleLog;

public class ScheduleLog {
    private int logId;
    private String userName;
    private Integer roomId;
    private String date;
    private int time;
    private String operation;
    private boolean resultSchedule;

    public ScheduleLog(int logId, String userName, Integer roomId, String date, int time, String operation,
            boolean resultSchedule) {
        setLogId(logId);
        setUserName(userName);
        setRoomId(roomId);
        setDate(date);
        setTime(time);
        setOperation(operation);
        setResultSchedule(resultSchedule);
    }

    public int getLogId() {
        return this.logId;
    }

    public String getUserName() {
        return this.userName;
    }

    public Integer getRoomId() {
        return this.roomId;
    }

    public String getDate() {
        return this.date;
    }

    public int getTime() {
        return this.time;
    }

    public boolean isResultSchedule() {
        return this.resultSchedule;
    }

    public String getOperation() {
        return this.operation;
    }

    private void setLogId(int logId) {
        this.logId = logId;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    private void setDate(String date) {
        this.date = date;
    }

    private void setTime(int time) {
        this.time = time;
    }

    private void setResultSchedule(boolean resultSchedule) {
        this.resultSchedule = resultSchedule;
    }

    private void setOperation(String operation) {
        this.operation = operation;
    }
}
