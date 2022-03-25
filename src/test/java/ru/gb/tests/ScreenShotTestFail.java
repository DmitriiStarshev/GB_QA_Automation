package ru.gb.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;
//@Listeners(AllureListener.class)
// перед каждым классом теста она должна быть. Иначе просто листенер не понимает, что мы хотим его использовать.
@Listeners(AllureListener.class)
public class ScreenShotTestFail extends BaseTest {

    @Test
    public void checkMainPageScreen(){
        openApp()
                .checkFailScreenshot();
    }
}
