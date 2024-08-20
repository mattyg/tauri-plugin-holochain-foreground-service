use tauri::{AppHandle, command, Runtime};

use crate::models::*;
use crate::Result;
use crate::HolochainForegroundServiceExt;

#[command]
pub(crate) async fn launch<R: Runtime>(
    app: AppHandle<R>,
    payload: HolochainRequest,
) -> Result<HolochainResponse> {
    app.holochain_foreground_service().launch(payload)
}
