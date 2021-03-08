package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class ListOfMapsOperation implements MapOperationsCreator {

    public ListOfMapsOperation() {
    }

    @Override
    public ArrayList<AbstractOperation> createFillingOperations(int size) {
        ArrayList<AbstractOperation> listOfMaps = new ArrayList<>();

        FillingHashMap preparingHashMap =
                new FillingHashMap(StorageCollectionsAndMaps.getInstance().getHashMap(),
                        size);
        FillingTreeMap preparingTreeMap =
                new FillingTreeMap(StorageCollectionsAndMaps.getInstance().getTreeMap(),
                        size);
        listOfMaps.add(preparingHashMap);
        listOfMaps.add(preparingTreeMap);
        return listOfMaps;
    }

    @Override
    public ArrayList<AbstractOperation> createMicroOperations(int idOperation) {
        if (idOperation == Keys.ID_HASH_MAP) {
            return buildHashMapOperations();
        } else if(idOperation == Keys.ID_TREE_MAP) {
            return buildTreeMapOperations();
        } else {
            return null;
        }
    }


    @Override
    public ArrayList<AbstractOperation> buildHashMapOperations() {
        ArrayList<AbstractOperation> listOfOperationsForHashMap = new ArrayList<>();
        AddingNewInHashMap addingNewInHashMap =
                new AddingNewInHashMap(StorageCollectionsAndMaps.getInstance().getHashMap());
        SearchByKeyInHashMap searchByKeyInHashMap =
                new SearchByKeyInHashMap(StorageCollectionsAndMaps.getInstance().getHashMap());
        RemovingInHashMap removingInHashMap =
                new RemovingInHashMap(StorageCollectionsAndMaps.getInstance().getHashMap());
        listOfOperationsForHashMap.add(addingNewInHashMap);
        listOfOperationsForHashMap.add(searchByKeyInHashMap);
        listOfOperationsForHashMap.add(removingInHashMap);
        return listOfOperationsForHashMap;
    }

    @Override
    public ArrayList<AbstractOperation> buildTreeMapOperations() {
        ArrayList<AbstractOperation> listOfOperationsForTreeMap = new ArrayList<>();
        AddingNewInTreeMap addingNewInTreeMap =
                new AddingNewInTreeMap(StorageCollectionsAndMaps.getInstance().getTreeMap());
        SearchByKeyInTreeMap searchByKeyInTreeMap =
                new SearchByKeyInTreeMap(StorageCollectionsAndMaps.getInstance().getTreeMap());
        RemovingInTreeMap removingInTreeMap =
                new RemovingInTreeMap(StorageCollectionsAndMaps.getInstance().getTreeMap());
        listOfOperationsForTreeMap.add(addingNewInTreeMap);
        listOfOperationsForTreeMap.add(searchByKeyInTreeMap);
        listOfOperationsForTreeMap.add(removingInTreeMap);
        return listOfOperationsForTreeMap;
    }



}
