package service;

import model.Instance;

public class InstanceCreator {
    public static final String DEPARTURE = "testdata.instance.departure";
    public static final String CHECK_IN_DATE = "testdata.instance.check-in-date";
    public static final String CHECK_OUT_DATE = "testdata.instance.check-out-date";
    public static final String ADULTS_COUNT = "testdata.instance.adults-count";
    public static final String CHILDREN_COUNT = "testdata.instance.children-count";
    public static final String ROOMS_COUNT = "testdata.instance.rooms-count";

    public static Instance getInstanceFromProperty() {
        return new Instance(TestDataReader.getTestData(DEPARTURE),
                TestDataReader.getTestData(CHECK_IN_DATE), TestDataReader.getTestData(CHECK_OUT_DATE),
                TestDataReader.getTestData(ADULTS_COUNT), TestDataReader.getTestData(CHILDREN_COUNT),
                TestDataReader.getTestData(ROOMS_COUNT));
    }
}
