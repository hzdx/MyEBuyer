package com.mycom.json;

import java.util.HashMap;

public class JsonResult extends HashMap<String,Object> {
        private static final String KEY_MESSAGE = "message";
        private static final String STATUS_MESSAGE = "status";

        public enum STATUS {
            OK, FAIL
        }


        public static final JsonResult OK = new JsonResult(STATUS.OK);
        public static final JsonResult FAIL = new JsonResult(STATUS.FAIL);

        @SuppressWarnings("unused")
        private JsonResult() {
        }

        /**

         * 构造包含 status 的JsonResult

         */
        public JsonResult(STATUS status) {
            this.put(STATUS_MESSAGE, status.name().toLowerCase());
        }

        public JsonResult(STATUS status, String message) {
            this(status);
            this.put(KEY_MESSAGE, message);
        }

        public JsonResult put(String key, Object value) {
            if (this == JsonResult.OK || this == JsonResult.FAIL) {
                JsonResult jr = (JsonResult)this.clone();
                jr.put(key, value);
                return jr;
            } else {
                super.put(key, value);
            }
            return this;
        }

        public JsonResult message(String message) {
            JsonResult result = (JsonResult)this.clone();
            result.put(KEY_MESSAGE, message);
            return result;
        }

        @Override
        public Object clone() {
            return super.clone();
        }
    }