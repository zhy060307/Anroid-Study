package zhy.com.serialport;

public enum LEDStatus {
    ON("0050410000FF00002F2F"), //default status
    OFF("660001000000"),
    RED("00504100FF0000002F0B"),
    GREEN("0050410000FF00002F2F"),
    YELLOW("00504100FFFF00001F3B"),
    CYAN("0050410000FFFF006EDF");

    private String data;

    LEDStatus(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public byte[] hexStringToByteArra() {
        int len = data.length();
        byte[] datas = new byte[(len / 2)];
        for (int i = 0; i < len; i += 2) {
            datas[i / 2] = (byte) ((Character.digit(data.charAt(i), 16) << 4) + Character.digit(data.charAt(i + 1), 16));
        }
        return datas;
    }
}