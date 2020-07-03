package system.test;

import com.github.jeansantos38.stf.enums.wait.ThreadWait;
import com.github.jeansantos38.stf.framework.datadriven.DesktopAutomationDataDrivenHelper;
import com.github.jeansantos38.stf.framework.desktop.DesktopAutomationHelper;
import com.github.jeansantos38.stf.framework.io.InputOutputHelper;
import com.github.jeansantos38.stf.framework.wait.WaitHelper;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.vnc.VNCScreen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import system.base.MainTestBase;

public class DesktopAutomation2 extends MainTestBase {

    private DesktopAutomationDataDrivenHelper dataDrivenHelper;
    private String folderWithMasterImages;
    private String navigatorFile;
    private String dataDrivenFile;
    private Pattern xButton;
    private String stf_win_app_demo;
    private Double similarity;
    private DesktopAutomationHelper desktopAutomationHelper;

    @BeforeClass
    public void beforeClass() throws Exception {
        testLog.logIt("Running before class steps");

        similarity = 0.92;

    }

    @Test(enabled = false)
    public void bomba() throws Exception {
        Screen screen = new Screen();

        String screenshotsDestination = System.getProperty("user.home") + "/STF_Screenshots";
        InputOutputHelper.createDirectory(screenshotsDestination);

        desktopAutomationHelper = new DesktopAutomationHelper(
                testLog,
                screen,
                screenshotsDestination,
                similarity,
                100,
                20,
                true,
                true,
                true);

        desktopAutomationHelper.saveDesktopScreenshot();
    }

    @Test
    public void bombaVNc() throws Exception {
        String screenshotsDestination = System.getProperty("user.home") + "/STF_Screenshots";
        InputOutputHelper.createDirectory(screenshotsDestination);
        VNCScreen screen = null;

        //screen = screen.start("192.168.0.29", 5900, "abc123", 30, 120);
        screen = screen.start("192.168.0.38", 5901, "abc123", 30, 120);
        //screen.getClient().refreshFramebuffer();

        new WaitHelper().wait(ThreadWait.WAIT_3_SEC);
        //screen.getImage().save("daksjhdalksjdha1", screenshotsDestination);


        Pattern zica = new Pattern("C:\\Users\\giacomin\\Documents\\SikuliX.sikuli\\1593487849458.png");
        zica.similar(0.75);
        screen.click(zica);


        //screen.getClient().setDesktopSize(1920, 1080);
        //screen.getClient().setsetDesktopSize(1920, 1080);

        new WaitHelper().wait(ThreadWait.WAIT_10_SEC);
        screen.getClient().refreshFramebuffer();
        screen.getImage().save("alopra22.png", screenshotsDestination);

        screen.stop();

//        desktopAutomationHelper = new DesktopAutomationHelper(
//                testLog,
//                screen,
//                screenshotsDestination,
//                similarity,
//                100,
//                20,
//                true,
//                true,
//                true);
//
//        desktopAutomationHelper.saveDesktopScreenshot();
    }

}
