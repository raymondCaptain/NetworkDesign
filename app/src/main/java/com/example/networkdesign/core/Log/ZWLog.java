package com.example.networkdesign.core.Log;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class ZWLog {
    public static int d(Object object) {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        // 调用者
        StackTraceElement callerElement = elements[1];

        return ZWLog.d(callerElement.getFileName(), object, callerElement.getFileName(), callerElement.getMethodName(), callerElement.getLineNumber());
    }

    public static int d(String tag, Object object) {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        // 调用者
        StackTraceElement callerElement = elements[1];

        return ZWLog.d(tag, object, callerElement.getFileName(), callerElement.getMethodName(), callerElement.getLineNumber());
    }

    public static int d(Object object, String fileName, String methodName, int lineNumber) {
        return ZWLog.d(fileName, object, fileName, methodName, lineNumber);
    }

    public static int d(String tag, Object object, String fileName, String methodName, int lineNumber) {
        try {
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(gson.toJson(object));
            return dMsg(tag, jsonObject.toString(4), fileName, methodName, lineNumber);
        } catch (JSONException e) {
            return dMsg(tag, object.toString(), fileName, methodName, lineNumber);
        }
    }

    private static int dMsg(String tag, String msg, String fileName, String methodName, int lineNumber) {
        String topDivider = " \n•---------------------------------------------------------------------------------------------------\n";
        String bottomDivider = " \n----------------------------------------------------------------------------------------------------\n";
        return Log.d(tag,  topDivider + "FileName: " + fileName + "    MethodName: " + methodName + "    LineNumber: " + lineNumber + "\n" + msg + bottomDivider);
    }
}
