package Main;

import Controller.LoginController;
import View.UI_Login;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;

/**
 *
 * @author franc
 */
public class Main {

    public static void main(String[] args) {
        try {
            Map<String, String> extraDefaults = new HashMap<>();
            extraDefaults.put("@accentColor", "#990033");
            //extraDefaults.put("@accentFocusColor", "#80E4FF");
            
            FlatLaf.setGlobalExtraDefaults(extraDefaults);
            FlatLightLaf.setup();
            // invoke FlatLaf.updateUI() if necessary
            // FlatLightLaf.setup();
            // UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 15);
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("Component.arc", 15);
            UIManager.put("Separator.stripeWidth", 3);
            UIManager.put("PasswordField.showRevealButton", true);
            UI_Login login = new UI_Login();
            LoginController start = new LoginController(login);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
