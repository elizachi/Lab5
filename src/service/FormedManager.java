package service;

import exceptions.EndException;
import handlers.InputHandler;
import source.HumanBeing;

public class FormedManager {
    private final AskInput request = new AskInput();

    public HumanBeing formed(InputHandler reader) throws EndException {
        return new HumanBeing(
                request.askName(reader),
                request.askSoundtrackName(reader),
                request.askMinutesOfWaiting(reader),
                request.askImpactSpeed(reader),
                request.askRealHero(reader),
                request.askHasToothpick(reader),
                request.askCoordinates(reader),
                request.askMood(reader),
                request.askCar(reader)
        );
    }

}
