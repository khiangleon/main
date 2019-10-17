package seedu.revision.logic.commands;

import static seedu.revision.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.revision.testutil.TypicalAnswerables.getTypicalRevisionTool;

import org.junit.jupiter.api.Test;

import seedu.revision.model.Model;
import seedu.revision.model.ModelManager;
import seedu.revision.model.RevisionTool;
import seedu.revision.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyRevisionTool_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyRevisionTool_success() {
        Model model = new ModelManager(getTypicalRevisionTool(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalRevisionTool(), new UserPrefs());
        expectedModel.setRevisionTool(new RevisionTool());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
