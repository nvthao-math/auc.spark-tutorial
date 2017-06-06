///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.business.stat;
//
//import com.spark.config.SparkClient;
//import java.io.PrintWriter;
//import java.io.Serializable;
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import org.apache.spark.Accumulator;
//import org.apache.spark.api.java.JavaPairRDD;
//import org.apache.spark.storage.StorageLevel;
//import org.json.JSONObject;
//import scala.Tuple2;
//
///**
// *
// * @author thaonv
// */
//public class UserQosJob extends SparkClient {
//
//    public static void main(String[] args) {
//        try {
//            UserQosJob job = new UserQosJob(_jsc, new HadoopSourceBuilder("hdfs://10.30.80.10:9200", "", ""));
//            Accumulator<StatEntry> statiticsVal = null;
//            JSONObject obj = job.execute(0l, statiticsVal);
//            System.out.println(obj.toString());
//        } catch (Exception ex) {
//            StringWriter error = new StringWriter();
//            ex.printStackTrace(new PrintWriter(error));
//            System.out.println(error.toString());
//        }
//    }
//
//    public JSONObject execute(long time, Accumulator<StatEntry> statiticsVal) {
//        JSONObject result = null;
//        try {
//            Map<String, Map<String, Long>> resultMap = new HashMap();
//            String sourceAPI = "/home/cpu10869-local/workspace/data/ZP_USER_QOS/collector129_08_ZP_USER_QOS_2017_05_11_09_07_57_008.log";
////            String sourceAPI = _input.getA1Source(UserQosSchema.CATENAME, time);
//            if (sourceAPI != null && !sourceAPI.isEmpty()) {
//                JavaPairRDD<String, Tuple2<Long, ErrorFrequency>> dataRDD = _jsc.textFile(sourceAPI)
//                        .flatMapToPair(line -> parseLog(line))
//                        .persist(StorageLevel.MEMORY_AND_DISK());
//                // get error and latency
//                JavaPairRDD<String, Tuple2<Long, ErrorFrequency>> latencyRDD = dataRDD
//                        .filter((Tuple2<String, Tuple2<Long, ErrorFrequency>> line) -> !line._1().contains("id_"))
//                        .reduceByKey((Tuple2<Long, ErrorFrequency> tupleX, Tuple2<Long, ErrorFrequency> tupleY) -> {
//                            Long latency = tupleX._1() + tupleY._1();
//                            ErrorFrequency error = tupleX._2().add(tupleY._2());
//                            Tuple2<Long, ErrorFrequency> tempt = new Tuple2(latency, error);
//                            return tempt;
//                        });
//                //
////                System.out.println("----------------------------------------------------");
//                // calculate A1 and totalA1
//                JavaPairRDD<String, Long> userIdRDD = dataRDD.filter((Tuple2<String, Tuple2<Long, ErrorFrequency>> line) -> line._1().contains("id_"))
//                        .flatMapToPair(record -> toCountA1(record))
//                        .reduceByKey((x, y) -> x + y);
//                UniqueByDimensionResult statsInfo = execUniqueByDimension(TAB_DELIMITER, userIdRDD, null);
//                Map<String, long[]> statsData = statsInfo.getData();
//                Long tempA1 = 0l;
//                Long tempTotalA1 = 0l;
//                for (String key : statsData.keySet()) {
//                    tempA1 += statsData.get(key)[0];
//                    tempTotalA1 += statsData.get(key)[1];
//                }
//                final Long uniqueA1 = tempA1;
//                final Long totalA1 = tempTotalA1;
////                System.out.println(GSON.toJson(statsData));
////                System.out.println("UniqueA1: " + uniqueA1);
////                System.out.println("TotalA1: " + totalA1);
////                System.out.println("-----------------------JSON-----------------------------");
//                latencyRDD.collect().forEach((Tuple2<String, Tuple2<Long, ErrorFrequency>> val) -> {
//                    Long latency = val._2()._1();
//                    Map<String, Long> getMap = val._2()._2().getData();
//                    for (String key : getMap.keySet()) {
//                        String dimension = new StringBuilder(val._1())
//                                .append(UNDER_SCORE)
//                                .append(key)
//                                .toString();
//                        Map<String, Long> data = new HashMap();
//                        data.put("latency", latency);
//                        data.put("error", getMap.get(key));
//                        data.put("A1", uniqueA1);
//                        data.put("totalA1", totalA1);
//                        // to result
//                        resultMap.put(dimension, data);
//                    }
//                });
//                result = new JSONObject(resultMap);
//            }
//        } catch (Exception ex) {
////            statiticsVal.add(new StatEntry(String.format("[ProcessException API] %s", Utils.getStackTrace(ex))));
//        }
////        System.out.println("JSON --> " + result.toString());
//        return result;
//    }
//
//    public static List<Tuple2<String, Long>> toCountA1(Tuple2<String, Tuple2<Long, ErrorFrequency>> record) {
//        List<Tuple2<String, Long>> result = new ArrayList<>();
//        result.add(new Tuple2(record._1(), record._2()._1()));
//        return result;
//    }
//
//    public static List<Tuple2<String, Tuple2<Long, ErrorFrequency>>> parseLog(String line) throws Exception {
//        List<Tuple2<String, Tuple2<Long, ErrorFrequency>>> result = new ArrayList<>();
//        String[] fields = line.split(TAB_DELIMITER, -1);
//        String userId = fields[UserQosSchema.USER_ID];
//        String userIp = fields[UserQosSchema.USER_IP];
//        String platform = fields[UserQosSchema.PLATFORM];
//        String connectionType = fields[UserQosSchema.CONNECTION_TYPE];
//        // String mnoCode = fields[UserQosSchema.MNO_CODE];
//        String testCaseId = fields[UserQosSchema.TEST_CASE_ID];
//        String errorCode = fields[UserQosSchema.ERROR_CODE];
//        String data = fields[UserQosSchema.DATA];
//        //
////        ZaloIp2GeoClientV2 client = ZaloIp2GeoClientV2.getInstance(JobSettings.getIpLocationHost(), JobSettings.getIpLocationPort());
////        TASNResult tasnResult = client.getASN(userIp);
//        String asn = null;
////        if (tasnResult.getError() >= 0) {
////            asn = tasnResult.getValue().getAsnCode() + "";
////        }
//        asn = "131124";
//        String isp = mapIsp(asn).get(0);
//        result.add(new Tuple2("id_" + userId, new Tuple2(1l, null)));
//        if ("469".equals(testCaseId)) {
//            String info = new StringBuilder(isp).append(HYPHEN_DELIMITER)
//                    .append(platform).append(HYPHEN_DELIMITER)
//                    .append((connectionType == null || connectionType.isEmpty()) ? UNDEFINED : connectionType)
//                    .toString();
//            Matcher latencyMatcher = LATENCY_PATTERN.matcher(data);
//            if (latencyMatcher.find()) {
//                Long latency = Long.parseLong(latencyMatcher.group(1));
//                result.add(new Tuple2(info, new Tuple2(latency, new ErrorFrequency(errorCode))));
//            }
//        }
//        return result;
//    }
//
//    private static List<String> mapIsp(String asn) {
//        List<String> re = new ArrayList();
//        if (asn != null) {
//            switch (asn) {
//                case "38731":
//                case "24086":
//                case "7552":
//                case "131124":
//                    re.add("viettel");
//                    break;
//                case "131429":
//                case "45895":
//                case "45896":
//                case "45897":
//                    re.add("mobifone");
//                    break;
//                case "45899":
//                case "7643":
//                    re.add("vnpt");
//                    break;
//                case "45894":
//                case "18403":
//                case "131402":
//                    re.add("fpt");
//                    break;
//                default:
//                    re.add("unknown");
//                    break;
//            }
//        } else {
//            re.add("unknown");
//        }
//        return re;
//    }
//
//    public static class ErrorFrequency implements Serializable {
//
//        private Map<String, Long> frequency;
//
//        // constructor
//        public ErrorFrequency(String type) {
//            if (this.frequency == null) {
//                this.frequency = new HashMap();
//            }
//            this.frequency.put(type, 1l);
//        }
//
//        public ErrorFrequency add(ErrorFrequency errorInfo) {
//            Map<String, Long> info = errorInfo.getData();
//            info.keySet().forEach((key) -> {
//                Long count = this.frequency.get(key);
//                this.frequency.put(key, count == null ? info.get(key) : info.get(key) + count);
//            });
//            return this;
//        }
//
//        public Map<String, Long> getData() {
//            return this.frequency;
//        }
//
//    }
//
//}
