import { NativeModules } from "react-native";

const show = (texto = "") => NativeModules.MinhaLibToast.exibirToast(texto);

export default show;
