package seedu.revision.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.revision.model.Model;
import seedu.revision.model.RevisionTool;

/**
 * Clears the revision tool.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Revision tool has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setRevisionTool(new RevisionTool());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
