package seedu.revision.model.answerable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.revision.testutil.Assert.assertThrows;
import static seedu.revision.testutil.TypicalAnswerables.ALICE;
import static seedu.revision.testutil.TypicalAnswerables.BOB;

import org.junit.jupiter.api.Test;

import seedu.revision.testutil.AnswerableBuilder;

public class AnswerableTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Answerable answerable = new AnswerableBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> answerable.getTags().remove(0));
    }

    @Test
    public void isSameAnswerable() {
        // same object -> returns true
        assertTrue(ALICE.isSameAnswerable(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameAnswerable(null));

        // different phone and email -> returns false
        Answerable editedAlice = new AnswerableBuilder(ALICE).withPhone(VALID_PHONE_BOB)
                .withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.isSameAnswerable(editedAlice));

        // different name -> returns false
        editedAlice = new AnswerableBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameAnswerable(editedAlice));

        // same name, same phone, different attributes -> returns true
        editedAlice = new AnswerableBuilder(ALICE).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameAnswerable(editedAlice));

        // same name, same email, different attributes -> returns true
        editedAlice = new AnswerableBuilder(ALICE).withPhone(VALID_PHONE_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameAnswerable(editedAlice));

        // same name, same phone, same email, different attributes -> returns true
        editedAlice = new AnswerableBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameAnswerable(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Answerable aliceCopy = new AnswerableBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different answerable -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Answerable editedAlice = new AnswerableBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new AnswerableBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new AnswerableBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new AnswerableBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new AnswerableBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}
