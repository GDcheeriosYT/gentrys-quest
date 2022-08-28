package InterfaceManager.GameInterfaces;

import InterfaceManager.*;

import java.util.ArrayList;

public class PlayInterface extends Interface {
    super(
        "",
        new OptionGroup(new ArrayList<Option>(List.of(
            new Option("travel", LocationsInterface),
            new Option("gacha", GachaInterface),
            new Option("inventory", InventoryInterface)
        ))),
    )
}