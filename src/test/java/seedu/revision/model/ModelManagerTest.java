package seedu.revision.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.revision.model.Model.PREDICATE_SHOW_ALL_ANSWERABLES;
import static seedu.revision.testutil.Assert.assertThrows;
import static seedu.revision.testutil.TypicalAnswerables.ALICE;
import static seedu.revision.testutil.TypicalAnswerables.BENSON;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.revision.commons.core.GuiSettings;
import seedu.revision.model.answerable.NameContainsKeywordsPredicate;
import seedu.revision.testutil.RevisionToolBuilder;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new RevisionTool(), new RevisionTool(modelManager.getRevisionTool()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setRevisionToolFilePath(Paths.get("revision/tool/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setRevisionToolFilePath(Paths.get("new/revision/tool/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setRevisionToolFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setRevisionToolFilePath(null));
    }

    @Test
    public void setRevisionToolFilePath_validPath_setsRevisionToolFilePath() {
        Path path = Paths.get("revision/tool/file/path");
        modelManager.setRevisionToolFilePath(path);
        assertEquals(path, modelManager.getRevisionToolFilePath());
    }

    @Test
    public void hasAnswerable_nullAnswerable_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasAnswerable(null));
    }

    @Test
    public void hasAnswerable_answerableNotInRevisionTool_returnsFalse() {
        assertFalse(modelManager.hasAnswerable(ALICE));
    }

    @Test
    public void hasAnswerable_answerableInRevisionTool_returnsTrue() {
        modelManager.addAnswerable(ALICE);
        assertTrue(modelManager.hasAnswerable(ALICE));
    }

    @Test
    public void getFilteredAnswerableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredAnswerableList().remove(0));
    }

    @Test
    public void equals() {
        RevisionTool revisionTool = new RevisionToolBuilder().withAnswerable(ALICE).withAnswerable(BENSON).build();
        RevisionTool differentRevisionTool = new RevisionTool();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = new ModelManager(revisionTool, userPrefs);
        ModelManager modelManagerCopy = new ModelManager(revisionTool, userPrefs);
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different revisionTool -> returns false
        assertFalse(modelManager.equals(new ModelManager(differentRevisionTool, userPrefs)));

        // different filteredList -> returns false
        String[] keywords = ALICE.getName().fullName.split("\\s+");
        modelManager.updateFilteredAnswerableList(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelManager(revisionTool, userPrefs)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredAnswerableList(PREDICATE_SHOW_ALL_ANSWERABLES);

        // different userPrefs -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setRevisionToolFilePath(Paths.get("differentFilePath"));
        assertFalse(modelManager.equals(new ModelManager(revisionTool, differentUserPrefs)));
    }
}
