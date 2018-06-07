package com.example.skadl.professortest;

import org.json.JSONObject;

/**
 * Created by skadl on 2018-05-18.
 */

public class DBConn {

    private String      ServerIP;
    private String      sendSentence;
    private JSONObject  returnValue;

    DBConn(){

    }

    //  로그인
    public JSONObject Login(String userId, String userPass){

        return returnValue;
    }

    //  담당 그룹 리스트
    public JSONObject MyGroup(String sessionId){

        return returnValue;
    }

    //  그룹 정보 리스트
    public JSONObject GroupInfo(String sessionId, String groupName){

        return returnValue;
    }

    //  질문 리스트
    public JSONObject FeedBackList(String sessionId){

        return returnValue;
    }

    //  질문 답변 리스트
    public JSONObject FeedBackComment(String sessionId, String title){

        return returnValue;
    }

    //  재시험 정보
    public JSONObject Retest(String sessionId, String testName, String studentName){

        return returnValue;
    }

    //  오답노트 정보
    public JSONObject note(String sessionId, String testName, String studentName){

        return returnValue;
    }

    //  피드백 답변 보내기
    public void SendComment(String sessionId, String questionId, String comment){

    }

}
