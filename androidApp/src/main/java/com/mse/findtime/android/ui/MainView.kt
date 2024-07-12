package com.mse.findtime.android.ui
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mse.findtime.android.MyApplicationTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.NavigationBarItemColors

sealed class Screen (val title:String) {
    object  TimeZonesScreen:Screen("Timezones")
    object FindTimeScreen:Screen("Find Time")
}
data class BottomItem(val route:String,val icon:ImageVector,val iconContentDescription:String)

val bottomNavigationItems= listOf(
    BottomItem(
        Screen.TimeZonesScreen.title,
        Icons.Filled.Language,
        "Timezones"
    ) ,   BottomItem(
            Screen.FindTimeScreen.title,
    Icons.Filled.Place,
    "Find Time"
)
)
@Composable
fun MainView(actionBarFun:topBarFun={ EmptyComposable()}){
    val showAddDialog = remember { mutableStateOf(false) }

var currentTimeZoneStrings= remember {
    SnapshotStateList<String>()
}
    val selectedIndex= remember {
        mutableIntStateOf(0)
    }
    MyApplicationTheme {
        Scaffold(topBar = {
            actionBarFun(selectedIndex.intValue)
        }, floatingActionButton = {
            if(selectedIndex.intValue==0){
                FloatingActionButton(
                    modifier = Modifier.padding(16.dp),
                    shape = FloatingActionButtonDefaults.largeShape,
                    contentColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        showAddDialog.value =true;
                    }) {
                    Icon(imageVector = Icons.Default.Add , contentDescription = "Add Timezone")
                    
                }

            }
        }, bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
                bottomNavigationItems.forEachIndexed() {
                    i,bottomNavigationItem->NavigationBarItem(
                    colors = NavigationBarItemColors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        unselectedIconColor = Color.Black,
                        disabledIconColor = Color.Gray,
                        disabledTextColor = Color.Gray,
                        unselectedTextColor = Color.Black,
                        selectedIndicatorColor = MaterialTheme.colorScheme.primary),
                    selected = selectedIndex.intValue==i,
                    label = { Text(bottomNavigationItem.route, style = MaterialTheme.typography.bodyMedium)},
                    onClick = { selectedIndex.intValue=i},
                    icon = { Icon(bottomNavigationItem.icon, contentDescription = bottomNavigationItem.iconContentDescription) })
                }

            }
        }) { padding->
            Box (modifier = Modifier.padding(padding)) {

            }

        }
    }
    }

