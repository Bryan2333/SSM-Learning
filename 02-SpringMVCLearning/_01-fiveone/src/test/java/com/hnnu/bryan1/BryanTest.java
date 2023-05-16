package com.hnnu.bryan1;

import com.hnnu.bryan1.service.BryanService;
import com.hnnu.bryan1.service.BryanServiceImpl;
import org.junit.jupiter.api.Test;

public class BryanTest {

    @Test
    public void testBryan() {
        BryanService bryanService = new BryanServiceImpl();
        bryanService.getBryan();
    }
}
