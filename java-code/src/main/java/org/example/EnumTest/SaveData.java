package org.example.EnumTest;

import java.util.HashMap;
import java.util.Map;

public class SaveData {
    // save msg
    protected Map<String, String[]> msgidMap = new HashMap<String, String[]>();
    // save args
    protected Map<String, String[]> argsMap = new HashMap<String, String[]>();

    protected void addData(String checkid, String[] msgid, String[] args) {
        msgidMap.put(checkid, msgid);
        argsMap.put(checkid, args);
    }

    // save msg
    public String getMsgid(String checkid) {
        return msgidMap.get(checkid)[0];
    }

    // save msgs
    public String[] getMsgids(String checkid) {
        return msgidMap.get(checkid);
    }

    // save arg
    public String getArg(String checkid) {
        return msgidMap.get(checkid)[0];
    }

    // save args
    public String[] getArgs(String checkid) {
        return msgidMap.get(checkid);
    }

    // clear Map
    public void clearMember() {
        msgidMap = new HashMap<String, String[]>();
        argsMap = new HashMap<String, String[]>();
    }

}
