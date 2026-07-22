# Fix KSP Processing Error in Room

The project is failing to build with a `PROCESSING_ERROR` during the KSP task. This is most likely caused by an invalid DAO method signature in `ColorDAO`. Specifically, the `@Delete` annotation is being used with an `Int` parameter, but Room requires `@Delete` methods to take an `@Entity` instance or a collection of entities.

Additionally, there is an unused `java.awt.Color` import in `RoomDB.kt` which should be removed to avoid potential issues in a Kotlin Multiplatform project.

## User Review Required

> [!IMPORTANT]
> I am changing the `deleteColor` method in `ColorDAO` from using `@Delete` to `@Query`. This is because deleting by ID is done via a SQL query, while `@Delete` is reserved for deleting entity objects.

## Proposed Changes

### [composeApp]

#### [MODIFY] [ColorDAO.kt](file:///home/mauricio/AndroidStudioProjects/Palette/composeApp/src/commonMain/kotlin/com/example/palette/dao/ColorDAO.kt)
- Change `@Delete suspend fun deleteColor(colorId: Int)` to `@Query("DELETE FROM colors WHERE id = :colorId") suspend fun deleteColor(colorId: Int)`.

#### [MODIFY] [RoomDB.kt](file:///home/mauricio/AndroidStudioProjects/Palette/composeApp/src/commonMain/kotlin/com/example/palette/room/RoomDB.kt)
- Remove unused `import java.awt.Color`.

## Verification Plan

### Automated Tests
- Run `:composeApp:kspDebugKotlinAndroid` to verify that KSP processing succeeds.
- Run a full build `:composeApp:assembleDebug`.
