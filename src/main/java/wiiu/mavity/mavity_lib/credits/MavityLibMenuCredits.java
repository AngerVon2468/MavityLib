package wiiu.mavity.mavity_lib.credits;

import com.google.common.collect.Lists;

import dev.isxander.mainmenucredits.api.MainMenuCreditAPI;

import net.minecraft.text.Text;

import wiiu.mavity.mavity_lib.MavityLib;

import java.util.List;

public class MavityLibMenuCredits implements MainMenuCreditAPI {

    @Override
    public List<Text> getTitleScreenBottomLeft() {
        return Lists.newArrayList(Text.translatable("titlescreen.mavity_lib.bottom_left"));
    }

    public static void registerMavityLibMenuCredits() {
        MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main menu credits class.");
    }
}