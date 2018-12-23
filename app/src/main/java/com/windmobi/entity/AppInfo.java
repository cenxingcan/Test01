package com.windmobi.entity;

import java.util.List;

public class AppInfo {

    /**
     * outputType : {"type":"APK"}
     * apkInfo : {"type":"MAIN","splits":[],"versionCode":1,"versionName":"1.0","enabled":true,"outputFile":"app-release.apk","fullName":"release","baseName":"release"}
     * path : app-release.apk
     * properties : {}
     */

    private static final String LOG_TAG = AppInfo.class.getSimpleName();

    private OutputTypeBean outputType;
    private ApkInfoBean apkInfo;
    private String path;
    private PropertiesBean properties;

    public OutputTypeBean getOutputType() {
        return outputType;
    }

    public void setOutputType(OutputTypeBean outputType) {
        this.outputType = outputType;
    }

    public ApkInfoBean getApkInfo() {
        return apkInfo;
    }

    public void setApkInfo(ApkInfoBean apkInfo) {
        this.apkInfo = apkInfo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public PropertiesBean getProperties() {
        return properties;
    }

    public void setProperties(PropertiesBean properties) {
        this.properties = properties;
    }

    public static class OutputTypeBean {
        /**
         * type : APK
         */

        private static final String TAG = "outputType";

        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(TAG).append(":");
            stringBuilder.append("{").append("type").append(":").append(type).append("}");
            return stringBuilder.toString();
        }
    }

    public static class ApkInfoBean {
        /**
         * type : MAIN
         * splits : []
         * versionCode : 1
         * versionName : 1.0
         * enabled : true
         * outputFile : app-release.apk
         * fullName : release
         * baseName : release
         */

        private static final String TAG = "apkInfo";

        private String type;
        private int versionCode;
        private String versionName;
        private boolean enabled;
        private String outputFile;
        private String fullName;
        private String baseName;
        private List<?> splits;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getOutputFile() {
            return outputFile;
        }

        public void setOutputFile(String outputFile) {
            this.outputFile = outputFile;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getBaseName() {
            return baseName;
        }

        public void setBaseName(String baseName) {
            this.baseName = baseName;
        }

        public List<?> getSplits() {
            return splits;
        }

        public void setSplits(List<?> splits) {
            this.splits = splits;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(TAG).append(":");
            stringBuilder.append("{");
            stringBuilder.append("type").append(":").append(type).append(",");
            stringBuilder.append("versionCode").append(":").append(versionCode).append(",");
            stringBuilder.append("versionName").append(":").append(versionName).append(",");
            stringBuilder.append("enabled").append(":").append(enabled).append(",");
            stringBuilder.append("outputFile").append(":").append(outputFile).append(",");
            stringBuilder.append("fullName").append(":").append(fullName).append(",");
            stringBuilder.append("baseName").append(":").append(baseName).append(",");
            stringBuilder.append("splits").append(":").append(splits);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class PropertiesBean {
        private static final String TAG = "properties";

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(TAG).append(":");
            stringBuilder.append("{");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(LOG_TAG);
        stringBuilder.append("{");
        if (outputType != null) {
            stringBuilder.append(outputType.toString()).append(",");
        }
        if (apkInfo != null) {
            stringBuilder.append(apkInfo.toString()).append(",");
        }
        stringBuilder.append("path" + ":" + path).append(",");
        if (properties != null) {
            stringBuilder.append(properties.toString());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
