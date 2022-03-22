package others;

import commands.Command;

public class Developer {
    Command insert;
    Command update;
    Command select;
    Command delete;

    public Developer(Command insert, Command update, Command select, Command delete){
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }
}
