package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class ListOfCollectionsOperation implements CollectionOperationsCreator {

    public ListOfCollectionsOperation() {
    }


    @Override
    public ArrayList<AbstractOperation> createFillingOperations(int size) {
        ArrayList<AbstractOperation> listOfCollections = new ArrayList<>();

        FillingArrayList preparingArrayList = new FillingArrayList(StorageCollectionsAndMaps.getInstance().getArrayList(),
                size);
        FillingLinkedList preparingLinkedList = new FillingLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList(),
                size);
        FillingCopyOnWriteArrayList preparingCopyOnWriteArrayList = new FillingCopyOnWriteArrayList(
                StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList(),
                size);
        listOfCollections.add(preparingArrayList);
        listOfCollections.add(preparingLinkedList);
        listOfCollections.add(preparingCopyOnWriteArrayList);
        return listOfCollections;
    }

    @Override
    public HashMap<Integer, List<AbstractOperation>> createMicroOperations() {
        HashMap<Integer, List<AbstractOperation>> operationsMap = new HashMap<>();
        operationsMap.put(Keys.ID_ARRAY_LIST, buildArrayListOperations());
        operationsMap.put(Keys.ID_LINKED_LIST, buildLinkedListOperations());
        operationsMap.put(Keys.ID_COPY_ON_WRITE_ARRAY_LIST, buildCopyOnWriteArrayListOperations());
                return operationsMap;
    }


    @Override
    public ArrayList<AbstractOperation> buildArrayListOperations() {
        ArrayList<AbstractOperation> listOfOperationsForArrayList = new ArrayList<>();

        AddInTheBeginningArrayList addInTheBeginningArrayList =
                new AddInTheBeginningArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        AddInTheMiddleArrayList addInTheMiddleArrayList =
                new AddInTheMiddleArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        AddInTheEndOfArrayList addInTheEndOfArrayList =
                new AddInTheEndOfArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        SearchByValueArrayList searchByValueArrayList =
                new SearchByValueArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        RemoveInTheBeginningArrayList removeInTheBeginningArrayList =
                new RemoveInTheBeginningArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        RemoveInTheMiddleArrayList removeInTheMIddleArrayList =
                new RemoveInTheMiddleArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        RemoveInTheEndArrayList removeInTheEndArrayList =
                new RemoveInTheEndArrayList(StorageCollectionsAndMaps.getInstance().getArrayList());
        listOfOperationsForArrayList.add(addInTheBeginningArrayList);
        listOfOperationsForArrayList.add(addInTheMiddleArrayList);
        listOfOperationsForArrayList.add(addInTheEndOfArrayList);
        listOfOperationsForArrayList.add(searchByValueArrayList);
        listOfOperationsForArrayList.add(removeInTheBeginningArrayList);
        listOfOperationsForArrayList.add(removeInTheMIddleArrayList);
        listOfOperationsForArrayList.add(removeInTheEndArrayList);
        return listOfOperationsForArrayList;
    }

    @Override
    public ArrayList<AbstractOperation> buildLinkedListOperations() {
        ArrayList<AbstractOperation> listOfOperationsForLinked = new ArrayList<>();

        AddInTheBeginningLinkedList addInTheBeginningLinkedList =
                new AddInTheBeginningLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        AddInTheMiddleLinkedList addInTheMiddleLinkedList =
                new AddInTheMiddleLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        AddInTheEndOfLinkedList addInTheEndOfLinkedList =
                new AddInTheEndOfLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        SearchByValueLinkedList searchByValueLinkedList =
                new SearchByValueLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        RemoveInTheBeginningLinkedList removeInTheBeginningLinkedList =
                new RemoveInTheBeginningLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        RemoveInTheMiddleLinkedList removeInTheMiddleLinkedList =
                new RemoveInTheMiddleLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        RemoveInTheEndLinkedList removeInTheEndLinkedList =
                new RemoveInTheEndLinkedList(StorageCollectionsAndMaps.getInstance().getLinkedList());
        listOfOperationsForLinked.add(addInTheBeginningLinkedList);
        listOfOperationsForLinked.add(addInTheMiddleLinkedList);
        listOfOperationsForLinked.add(addInTheEndOfLinkedList);
        listOfOperationsForLinked.add(searchByValueLinkedList);
        listOfOperationsForLinked.add(removeInTheBeginningLinkedList);
        listOfOperationsForLinked.add(removeInTheMiddleLinkedList);
        listOfOperationsForLinked.add(removeInTheEndLinkedList);
        return listOfOperationsForLinked;
    }

    @Override
    public ArrayList<AbstractOperation> buildCopyOnWriteArrayListOperations() {
        ArrayList<AbstractOperation> listOfOperationsForCopyOnWriteArrayList = new ArrayList<>();

        AddInTheBeginningCopyOnWriteArrayList addInTheBeginningCopyOnWriteArrayList =
                new AddInTheBeginningCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());
        AddInTheMiddleCopyOnWriteArrayList addInTheMiddleCopyOnWriteArrayList =
                new AddInTheMiddleCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());
        AddInTheEndCopyOnWriteArrayList addInTheEndCopyOnWriteArrayList =
                new AddInTheEndCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());
        SearchByValueCopyOnWriteArrayList searchByValueCopyOnWriteArrayList =
                new SearchByValueCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());
        RemoveInTheBeginningCopyOnWriteArrayList removeInTheBeginningCopyOnWriteArrayList =
                new RemoveInTheBeginningCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());
        RemoveInTheMiddleCopyOnWriteArrayList removeInTheMiddleCopyOnWriteArrayList =
                new RemoveInTheMiddleCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());
        RemoveInTheEndCopyOnWriteArrayList removeInTheEndCopyOnWriteArrayList =
                new RemoveInTheEndCopyOnWriteArrayList(StorageCollectionsAndMaps.getInstance().getCopyOnWriteArrayList());

        listOfOperationsForCopyOnWriteArrayList.add(addInTheBeginningCopyOnWriteArrayList);
        listOfOperationsForCopyOnWriteArrayList.add(addInTheMiddleCopyOnWriteArrayList);
        listOfOperationsForCopyOnWriteArrayList.add(addInTheEndCopyOnWriteArrayList);
        listOfOperationsForCopyOnWriteArrayList.add(searchByValueCopyOnWriteArrayList);
        listOfOperationsForCopyOnWriteArrayList.add(removeInTheBeginningCopyOnWriteArrayList);
        listOfOperationsForCopyOnWriteArrayList.add(removeInTheMiddleCopyOnWriteArrayList);
        listOfOperationsForCopyOnWriteArrayList.add(removeInTheEndCopyOnWriteArrayList);
        return listOfOperationsForCopyOnWriteArrayList;
    }

}
