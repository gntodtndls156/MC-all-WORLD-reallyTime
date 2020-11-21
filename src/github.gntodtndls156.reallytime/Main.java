package github.gntodtndls156.reallytime;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Calendar;
import java.util.List;

public class Main extends JavaPlugin {
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();


        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                List<World> worlds = getServer().getWorlds();
                for (World world : worlds) {
                    // System.out.println(world.getName() + " : " + world.getFullTime() + "getFulltime, "+ world.getTime() + "gettime");
                    Calendar calendar = Calendar.getInstance();
                    int sumSec = 0;
                    sumSec = calendar.get(calendar.HOUR_OF_DAY) * 60 * 60;
                    sumSec = calendar.get(calendar.MINUTE) * 60;
                    sumSec = calendar.get(calendar.SECOND);

                    sumSec -= 6000;
                    if (sumSec < 0) {
                        sumSec += 24000;
                    }
                    world.setTime(sumSec);
                }
            }
        }, 1, 5);
    }
}