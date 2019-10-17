package seedu.revision.model.answerable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.revision.testutil.Assert.assertThrows;
import static seedu.revision.testutil.TypicalAnswerables.ALICE;
import static seedu.revision.testutil.TypicalAnswerables.BOB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.revision.model.answerable.exceptions.AnswerableNotFoundException;
import seedu.revision.model.answerable.exceptions.DuplicateAnswerableException;
import seedu.revision.testutil.AnswerableBuilder;

public class UniqueAnswerableListTest {

    private final UniqueAnswerableList uniqueAnswerableList = new UniqueAnswerableList();

    @Test
    public void contains_nullAnswerable_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList.contains(null));
    }

    @Test
    public void contains_answerableNotInList_returnsFalse() {
        assertFalse(uniqueAnswerableList.contains(ALICE));
    }

    @Test
    public void contains_answerableInList_returnsTrue() {
        uniqueAnswerableList.add(ALICE);
        assertTrue(uniqueAnswerableList.contains(ALICE));
    }

    @Test
    public void contains_answerableWithSameIdentityFieldsInList_returnsTrue() {
        uniqueAnswerableList.add(ALICE);
        Answerable editedAlice = new AnswerableBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(uniqueAnswerableList.contains(editedAlice));
    }

    @Test
    public void add_nullAnswerable_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList.add(null));
    }

    @Test
    public void add_duplicateAnswerable_throwsDuplicateAnswerableException() {
        uniqueAnswerableList.add(ALICE);
        assertThrows(DuplicateAnswerableException.class, () -> uniqueAnswerableList.add(ALICE));
    }

    @Test
    public void setAnswerable_nullTargetAnswerable_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList.setAnswerable(null, ALICE));
    }

    @Test
    public void setAnswerable_nullEditedAnswerable_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList.setAnswerable(ALICE, null));
    }

    @Test
    public void setAnswerable_targetAnswerableNotInList_throwsAnswerableNotFoundException() {
        assertThrows(AnswerableNotFoundException.class, () -> uniqueAnswerableList.setAnswerable(ALICE, ALICE));
    }

    @Test
    public void setAnswerable_editedAnswerableIsSameAnswerable_success() {
        uniqueAnswerableList.add(ALICE);
        uniqueAnswerableList.setAnswerable(ALICE, ALICE);
        UniqueAnswerableList expectedUniqueAnswerableList = new UniqueAnswerableList();
        expectedUniqueAnswerableList.add(ALICE);
        assertEquals(expectedUniqueAnswerableList, uniqueAnswerableList);
    }

    @Test
    public void setAnswerable_editedAnswerableHasSameIdentity_success() {
        uniqueAnswerableList.add(ALICE);
        Answerable editedAlice = new AnswerableBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        uniqueAnswerableList.setAnswerable(ALICE, editedAlice);
        UniqueAnswerableList expectedUniqueAnswerableList = new UniqueAnswerableList();
        expectedUniqueAnswerableList.add(editedAlice);
        assertEquals(expectedUniqueAnswerableList, uniqueAnswerableList);
    }

    @Test
    public void setAnswerable_editedAnswerableHasDifferentIdentity_success() {
        uniqueAnswerableList.add(ALICE);
        uniqueAnswerableList.setAnswerable(ALICE, BOB);
        UniqueAnswerableList expectedUniqueAnswerableList = new UniqueAnswerableList();
        expectedUniqueAnswerableList.add(BOB);
        assertEquals(expectedUniqueAnswerableList, uniqueAnswerableList);
    }

    @Test
    public void setAnswerable_editedAnswerableHasNonUniqueIdentity_throwsDuplicateAnswerableException() {
        uniqueAnswerableList.add(ALICE);
        uniqueAnswerableList.add(BOB);
        assertThrows(DuplicateAnswerableException.class, () -> uniqueAnswerableList.setAnswerable(ALICE, BOB));
    }

    @Test
    public void remove_nullAnswerable_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList.remove(null));
    }

    @Test
    public void remove_answerableDoesNotExist_throwsAnswerableNotFoundException() {
        assertThrows(AnswerableNotFoundException.class, () -> uniqueAnswerableList.remove(ALICE));
    }

    @Test
    public void remove_existingAnswerable_removesAnswerable() {
        uniqueAnswerableList.add(ALICE);
        uniqueAnswerableList.remove(ALICE);
        UniqueAnswerableList expectedUniqueAnswerableList = new UniqueAnswerableList();
        assertEquals(expectedUniqueAnswerableList, uniqueAnswerableList);
    }

    @Test
    public void setAnswerables_nullUniqueAnswerableList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList
                .setAnswerables((UniqueAnswerableList) null));
    }

    @Test
    public void setAnswerables_uniqueAnswerableList_replacesOwnListWithProvidedUniqueAnswerableList() {
        uniqueAnswerableList.add(ALICE);
        UniqueAnswerableList expectedUniqueAnswerableList = new UniqueAnswerableList();
        expectedUniqueAnswerableList.add(BOB);
        uniqueAnswerableList.setAnswerables(expectedUniqueAnswerableList);
        assertEquals(expectedUniqueAnswerableList, uniqueAnswerableList);
    }

    @Test
    public void setAnswerables_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueAnswerableList.setAnswerables((List<Answerable>) null));
    }

    @Test
    public void setAnswerables_list_replacesOwnListWithProvidedList() {
        uniqueAnswerableList.add(ALICE);
        List<Answerable> answerableList = Collections.singletonList(BOB);
        uniqueAnswerableList.setAnswerables(answerableList);
        UniqueAnswerableList expectedUniqueAnswerableList = new UniqueAnswerableList();
        expectedUniqueAnswerableList.add(BOB);
        assertEquals(expectedUniqueAnswerableList, uniqueAnswerableList);
    }

    @Test
    public void setAnswerables_listWithDuplicateAnswerables_throwsDuplicateAnswerableException() {
        List<Answerable> listWithDuplicateAnswerables = Arrays.asList(ALICE, ALICE);
        assertThrows(DuplicateAnswerableException.class, () -> uniqueAnswerableList
                .setAnswerables(listWithDuplicateAnswerables));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueAnswerableList.asUnmodifiableObservableList().remove(0));
    }
}
