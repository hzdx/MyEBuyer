package com.mycom.DaoTest;

import com.mycom.json.JsonResult;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void testEnum(){
        System.out.println(JsonResult.STATUS.OK);
    }
}
