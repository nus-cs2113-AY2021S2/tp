package control;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import entity.Facility;
import entity.Library;
import entity.Location;
import exceptions.BuildingNotFoundException;

class FindInBuildingTest {
    FindInBuilding moduleUnderTest;

    @Test
    void findByBuildingName_validBuildingOneFacility_returnsResults() {
        try (MockedStatic<FileManager> theMock = mockStatic(FileManager.class)) {
            List<Facility> fakeLibraries = new ArrayList<>();
            fakeLibraries.add(new Library(69, "library69", new Location(6.9, 6.9,
                    "N4-01-01", "NorthSpine")));
            theMock.when( FileManager::getFacilities ).thenReturn( fakeLibraries );
            assertDoesNotThrow(() -> moduleUnderTest.findByBuildingName("NorthSpine"));
        }
    }
    @Test
    void findByBuildingName_invalidBuilding_throwsException() {
        try (MockedStatic<FileManager> theMock = mockStatic(FileManager.class)) {
            List<Facility> fakeLibraries = new ArrayList<>();
            fakeLibraries.add(new Library(69, "library69", new Location(6.9, 6.9,
                    "N4-01-01", "NorthSpine")));
            theMock.when( FileManager::getFacilities ).thenReturn( fakeLibraries );
            assertThrows(BuildingNotFoundException.class, () -> moduleUnderTest.findByBuildingName("Atlantis"));
        }
    }
}