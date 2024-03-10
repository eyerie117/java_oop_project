package Heroes;

import java.util.ArrayList;

public interface Step {
    void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam);
}
