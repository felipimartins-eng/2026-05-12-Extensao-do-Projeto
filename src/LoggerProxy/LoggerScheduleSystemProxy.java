package LoggerProxy;

import interfaces.IPolicyStrategy;
import interfaces.IScheduleSystem;
import observers.User;
import rooms.BaseRoom;
import java.util.HashMap;
import ScheduleLog.ScheduleLog;
import ScheduleLogRepository.ScheduleLogRepositoryAbstract;

public class LoggerScheduleSystemProxy implements IScheduleSystem {
    private IScheduleSystem system;

    private ScheduleLogRepositoryAbstract dataBase;

    public LoggerScheduleSystemProxy(IScheduleSystem system, ScheduleLogRepositoryAbstract db) {
        this.setSystem(system);
        this.setDataBase(db);
    }

    // Getters e Setters
    public void setSystem(IScheduleSystem system) {
        this.system = system;
    }

    public IScheduleSystem getSystem() {
        return this.system;
    }

    public void setDataBase(ScheduleLogRepositoryAbstract db) {
        this.dataBase = db;
    }

    public ScheduleLogRepositoryAbstract getDataBase() {
        return this.dataBase;
    }

    // Métodos para o lançamento dos logs no Banco de Dados
    private void saveScheduleLog(ScheduleLog log) {
        this.getDataBase().addLog(log);
    }

    // Implementação dos métodos da Interface de Schedule System
    @Override
    public void setPolicy(IPolicyStrategy newPolicy) {
        this.system.setPolicy(newPolicy);
    }

    @Override
    public void newUser(String username, String role) {
        this.system.newUser(username, role);
    }

    @Override
    public void newRoom(int roomId, int roomType) {
        this.system.newRoom(roomId, roomType);
    }

    @Override
    public boolean makeSchedule(User user, Integer roomId, String date, int time) {
        boolean success = this.system.makeSchedule(user, roomId, date, time);
        ScheduleLogRepositoryAbstract db = this.getDataBase();
        this.saveScheduleLog(
                new ScheduleLog(user.getName(), roomId, date, time, "TENTATIVA DE RESERVA", success));
        return success;
    }

    @Override
    public boolean cancelSchedule(User user, Integer roomId, String date, int time) {
        boolean success = this.system.cancelSchedule(user, roomId, date, time);
        ScheduleLogRepositoryAbstract db = this.getDataBase();
        this.saveScheduleLog(new ScheduleLog(user.getName(), roomId, date, time,
                "CANCELAMENTO DE RESERVA", success));
        return success;
    }

    @Override
    public HashMap<Integer, BaseRoom> getRooms(String begin, String end, boolean fullOnly) {
        return this.system.getRooms(begin, end, fullOnly);
    }

    @Override
    public void reportRooms(String begin, String end, boolean fullOnly) {
        this.system.reportRooms(begin, end, fullOnly);
    }

}
