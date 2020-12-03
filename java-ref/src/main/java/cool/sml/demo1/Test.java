package cool.sml.demo1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/27
 */
public class Test {
    // 获取电脑 cpu_id
    private static final String GET_CPU_ID_COMMAND = "wmic cpu get processorid";
    // 获取电脑硬盘序列号
    private static final String GET_DISK_ID_COMMAND = "wmic diskdrive get serialnumber";
    // 获取主板smBIOS UUID
    private static final String GET_BIOS_ID_COMMAND = "wmic csproduct get UUID";

    public static void main(String[] args) throws Exception {

        //System.out.println(getWindowsInfo(GET_DISK_ID_COMMAND));

    }


    private static String getWindowsInfo(String command) {
        StringBuilder sb = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(command);

            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(process.getInputStream()));

            String data;
            while ((data = lnr.readLine()) != null) {
                sb.append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] dataArr = sb.toString().split("\\s+");
        if (dataArr.length > 1) {
            return dataArr[1];
        } else {
            return null;
        }
    }
}
