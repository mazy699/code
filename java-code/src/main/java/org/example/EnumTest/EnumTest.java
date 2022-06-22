package org.example.EnumTest;

public class EnumTest extends SaveData {
    public static void main(String[] args) {
        new EnumTest().touroku();
    }

    public void touroku() {
        String timing = "1";
        createCheckTable();
        checkKanren(timing);
    }

    private void createCheckTable() {
        String[] msgs;
        String[] args;

        clearMember();

        msgs = new String[]{"1111", "2222"};
        args = new String[]{"aaaa", "bbbb"};
        addData(CheckID.CK001.value, msgs, args);

        msgs = new String[]{"3333", "4444"};
        args = new String[]{"cccc", "dddd"};
        addData(CheckID.CK002.value, msgs, args);

        msgs = new String[]{"5555", "6666"};
        args = new String[]{"eeee", "ffff"};
        addData(CheckID.CK003.value, msgs, args);
    }

    private boolean checkKanren(String timing) {
        final CheckID[] targetID1 = new CheckID[]{
                CheckID.CK001, CheckID.CK002
        };
        final CheckID[] targetID2 = new CheckID[]{
                CheckID.CK001, CheckID.CK003
        };
        final CheckID[] targetID3 = new CheckID[]{
                CheckID.CK002, CheckID.CK003
        };
        final CheckID[] targetID4 = new CheckID[]{
                CheckID.CK001, CheckID.CK002, CheckID.CK003
        };

        if ("1".equals(timing)) {
            return check(targetID1);
        } else if ("2".equals(timing)) {
            return check(targetID2);
        } else if ("3".equals(timing)) {
            return check(targetID3);
        } else {
            return check(targetID4);
        }
    }

    private boolean check(CheckID[] checkIDs) {
        boolean ret = false;

        for (CheckID checkID : checkIDs) {
            checkItem(checkID);
            ret = true;
        }

        return ret;
    }

    private void checkItem(CheckID checkID) {
        String value = checkID.value;

        switch (checkID) {
            case CK001:
                getMsgid(value);
                getArgs(value);
                break;
            case CK002:
                getMsgid(value);
                getArgs(value);
                break;
            case CK003:
                getMsgid(value);
                getArgs(value);
                break;
            default:
                break;
        }
    }

    public enum CheckID {
        CK001("CK001"), CK002("CK002"), CK003("CK003");

        String value;

        CheckID(String value) {
            this.value = value;
        }
    }
}
