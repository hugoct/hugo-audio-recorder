import { NativeModules } from "react-native";

export const startRecord = (fileName) => NativeModules.HugoAudioRecorder.startRecord(fileName);
export const stopRecord = () => NativeModules.HugoAudioRecorder.stopRecord();