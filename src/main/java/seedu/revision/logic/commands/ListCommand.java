package seedu.revision.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.revision.model.Model.PREDICATE_SHOW_ALL_ANSWERABLES;

import seedu.revision.model.Model;

/**
 * Lists all answerables in the revision tool to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all questions";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAnswerableList(PREDICATE_SHOW_ALL_ANSWERABLES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
