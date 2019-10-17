package seedu.revision.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.revision.logic.commands.exceptions.CommandException;
import seedu.revision.model.Model;
import seedu.revision.model.answerable.Answerable;

/**
 * Adds an answerable to the revision tool.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a question to the question bank. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = "New question added: %1$s";
    public static final String MESSAGE_DUPLICATE_ANSWERABLE = "This question already exists in the question bank";

    private final Answerable toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Answerable}
     */
    public AddCommand(Answerable answerable) {
        requireNonNull(answerable);
        toAdd = answerable;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasAnswerable(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_ANSWERABLE);
        }

        model.addAnswerable(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
