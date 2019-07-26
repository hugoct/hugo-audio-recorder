import { NativeModules } from "react-native";

export const startRecord = (fileName, successCallback, errorCallback) =>
  NativeModules.HugoAudioRecorder.startRecord(
    fileName,
    successCallback,
    errorCallback
  );

export const stopRecord = (successCallback, errorCallback) =>
  NativeModules.HugoAudioRecorder.stopRecord(successCallback, errorCallback);

export const playRecord = fileName =>
  NativeModules.HugoAudioRecorder.playRecord(fileName);

export const stopPlayingRecord = () =>
  NativeModules.HugoAudioRecorder.stopPlayingRecord();

export const deleteRecord = (fileName, successCallback, errorCallback) =>
  NativeModules.HugoAudioRecorder.deleteRecord(
    fileName,
    successCallback,
    errorCallback
  );
