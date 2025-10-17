package com.bloodbank.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CompatibilityBloodtype {


    private static final Map<BloodType, List<BloodType>> compatibilityMap = new EnumMap<>(BloodType.class);

    static {
        compatibilityMap.put(BloodType.O_negative, List.of(
                BloodType.O_negative, BloodType.O_positive,
                BloodType.A_negative, BloodType.A_positive,
                BloodType.B_negative, BloodType.B_positive,
                BloodType.AB_negative, BloodType.AB_positive));

        compatibilityMap.put(BloodType.O_positive, List.of(
                BloodType.O_positive, BloodType.A_positive,
                BloodType.B_positive, BloodType.AB_positive));

        compatibilityMap.put(BloodType.A_negative, List.of(
                BloodType.A_negative, BloodType.A_positive,
                BloodType.AB_negative, BloodType.AB_positive));

        compatibilityMap.put(BloodType.A_positive, List.of(
                BloodType.A_positive, BloodType.AB_positive));

        compatibilityMap.put(BloodType.B_negative, List.of(
                BloodType.B_negative, BloodType.B_positive,
                BloodType.AB_negative, BloodType.AB_positive));

        compatibilityMap.put(BloodType.B_positive, List.of(
                BloodType.B_positive, BloodType.AB_positive));

        compatibilityMap.put(BloodType.AB_negative, List.of(
                BloodType.AB_negative, BloodType.AB_positive));

        compatibilityMap.put(BloodType.AB_positive, List.of(
                BloodType.AB_positive));
    }

    public static boolean isCompatible(BloodType donorBloodType, BloodType recipientBloodType) {
        if (donorBloodType == null || recipientBloodType == null) {
            return false;
        }
        List<BloodType> compatibleRecipients = compatibilityMap.get(donorBloodType);
        return compatibleRecipients != null && compatibleRecipients.contains(recipientBloodType);
    }

    public static List<BloodType> getCompatibleRecipients(BloodType donorBloodType) {
        return compatibilityMap.getOrDefault(donorBloodType, List.of());
    }
}
